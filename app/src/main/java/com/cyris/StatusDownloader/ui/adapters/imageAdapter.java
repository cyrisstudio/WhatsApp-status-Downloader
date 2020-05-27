package com.cyris.StatusDownloader.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cyris.StatusDownloader.LoadImage;
import com.cyris.StatusDownloader.R;
import com.cyris.StatusDownloader.ui.DownloadFile;
import com.cyris.StatusDownloader.ui.GetFile;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class imageAdapter extends RecyclerView.Adapter<imageAdapter.ImageViewHolder> {

    ArrayList<String> imageSoureList;
    final public Context context;
    private InterstitialAd mInterstitialAd;

    public imageAdapter(Context ctx)
    {
        context = ctx;
        if(imageSoureList==null)
            imageSoureList = GetFile.setImageSource();
        notifyDataSetChanged();
                mInterstitialAd = new InterstitialAd(context);
                mInterstitialAd.setAdUnitId("ca-app-pub-9531546526616195/2809156975");
                mInterstitialAd.loadAd(new AdRequest.Builder().build());

    }
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.image_holder,parent,false);

        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.LoadImage(imageSoureList.get(position));
        holder.ImageClick(position);
        holder.DownloadClick(position);
    }

    @Override
    public int getItemCount() {
        return imageSoureList.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageInImageHolder,downloadButton;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageInImageHolder = itemView.findViewById(R.id.imageInImageHolder);
            downloadButton = itemView.findViewById(R.id.downloadInImageHolder);
        }

        public void LoadImage(String uri)
        {
            /*Uri uri1 = Uri.parse(uri);
            imageInImageHolder.setImageURI(uri1); */
            AnimationSet animationSet = new AnimationSet(context,null);
            animationSet.addAnimation(new AlphaAnimation((float)0.1,(float)0.9));
            animationSet.addAnimation(new TranslateAnimation(-imageInImageHolder.getWidth(),0,0,0));
            animationSet.setDuration(300);
            imageInImageHolder.setAnimation(animationSet);
            File file = new File(uri);

            Picasso.get().load(file).resize(300,300).into(imageInImageHolder);
           // Glide.with(context).load(uri1).into(imageInImageHolder);
           // Picasso.with(context).load(uri).into(imageInImageHolder);
        }

        public void ImageClick(final int pos) {
            imageInImageHolder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, LoadImage.class);
                    intent.putExtra("imageIntent",imageSoureList);
                    intent.putExtra("position",pos);
                    context.startActivity(intent);
                }
            });

        }

        public void DownloadClick(final int pos)
        {
            Random random = new Random();
            final int randomNum = random.nextInt(3);
            downloadButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(randomNum==1)
                        if(mInterstitialAd.isLoaded())
                        {
                            mInterstitialAd.show();
                            mInterstitialAd = new InterstitialAd(context);
                            mInterstitialAd.setAdUnitId("ca-app-pub-9531546526616195/2809156975");
                            mInterstitialAd.loadAd(new AdRequest.Builder().build());
                            notifyDataSetChanged();
                        }

                    Toast.makeText(context,"Image Saved",Toast.LENGTH_SHORT).show();
                    downloadButton.setClickable(false);
                    try {
                        DownloadFile.DownloadFile1(imageSoureList.get(pos),context);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
