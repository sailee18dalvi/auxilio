package com.nabeel.auxilio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nabeel.auxilio.R;

public class SyllabusAdapter extends BaseAdapter {

    //private MainActivity mainActivity;
	private SyllabusActivity mcontext;
    //private SyllabusTEActivity mcontextte;
    //private SyllabusBEActivity mcontextbe;
    String[] Name ={"FE","SE"," TE"," BE","SE"," TE"," BE","SE"," TE"," BE","SE"," TE"," BE","SE"," TE"," BE","SE"," TE"," BE","SE"," TE"," BE"};
    String[] Owner={"Common","Automobile","Automobile","Automobile", "Bio-Technology","Bio-Technology","Bio-Technology",
            "Civil","Civil","Civil","Computer","Computer","Computer", "Electronics","Electronics","Electronics",
            "Electrical & Telecommunication", "Electrical & Telecommunication", "Electrical & Telecommunication",
            "Mechanical","Mechanical","Mechanical"};

    String[] Email={"Common","Automobile","Automobile","Automobile", "Bio-Technology","Bio-Technology","Bio-Technology",
            "Civil","Civil","Civil","Computer","Computer","Computer", "Electronics","Electronics","Electronics",
            "Electrical & Telecommunication", "Electrical & Telecommunication", "Electrical & Telecommunication",
            "Mechanical","Mechanical","Mechanical"};



    int[] pic = {R.drawable.p2,R.drawable.p2,R.drawable.p2,R.drawable.p2,R.drawable.p2,R.drawable.p2,R.drawable.p2,
                 R.drawable.p2,R.drawable.p2,R.drawable.p2,R.drawable.p2,R.drawable.p2,R.drawable.p2,R.drawable.p2,
                R.drawable.p2,R.drawable.p2,R.drawable.p2,R.drawable.p2,R.drawable.p2,R.drawable.p2,R.drawable.p2,
            R.drawable.p2};
	
    public SyllabusAdapter(SyllabusActivity mcontext) {
        this.mcontext = mcontext;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.syllabus_list_row, parent, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.notes_img);
        TextView owner=(TextView) view.findViewById(R.id.owner_name_txt);
        TextView email=(TextView) view.findViewById(R.id.owner_email);
        TextView name=(TextView) view.findViewById(R.id.notes_name_txt);
        name.setText(Name[position]);
        owner.setText(Owner[position]);
        email.setText(Email[position]);
        imageView.setImageResource(pic[position]);


        /*imageView.setImageResource(mcontext.getResources().getIdentifier("p" + (position + 1),
                "drawable", mcontext.getPackageName()));*/


        //ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        //imageView.setImageResource(mcontext.getResources().getIdentifier("p" + (position + 1),"drawable", mcontext.getPackageName()));
        return view;
    }
}
