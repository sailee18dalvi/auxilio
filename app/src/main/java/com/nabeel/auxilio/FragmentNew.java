package com.nabeel.auxilio;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Sailee on 10-03-2017.
 */

public class FragmentNew extends Fragment implements View.OnClickListener{
    View myView;
    private Button FindBtn, BecomeBtn, SyllabusBtn, PapersBtn, NotesBtn, ClassesBtn, ExamsBtn, CollegesBtn;
    private ImageView FindImg, BecomeImg, SyllabusImg, PapersImg, NotesImg, ClassesImg, ExamsImg, CollegesImg;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            myView = inflater.inflate(R.layout.fragment_new,container,false);


        FindBtn = (Button) myView.findViewById(R.id.findbtn);
        BecomeBtn = (Button) myView.findViewById(R.id.becomebtn);
        SyllabusBtn = (Button) myView.findViewById(R.id.syllabusbtn);
        CollegesBtn = (Button) myView.findViewById(R.id.collegesbtn);
        ClassesBtn = (Button) myView.findViewById(R.id.classbtn);
        NotesBtn = (Button) myView.findViewById(R.id.notesbtn);
        ExamsBtn = (Button) myView.findViewById(R.id.exambtn);
        PapersBtn = (Button) myView.findViewById(R.id.paperbtn);

        /*FindImg = (ImageView) myView.findViewById(R.id.findimg);
        BecomeImg = (ImageView) myView.findViewById(R.id.becomeimg);
        SyllabusImg = (ImageView) myView.findViewById(R.id.syllabusimg);
        CollegesImg = (ImageView) myView.findViewById(R.id.collegesimg);
        ClassesImg = (ImageView) myView.findViewById(R.id.classimg);
        NotesImg = (ImageView) myView.findViewById(R.id.notesimg);
        ExamsImg = (ImageView) myView.findViewById(R.id.examimg);
        PapersImg = (ImageView) myView.findViewById(R.id.paperimg);*/

        FindBtn.setOnClickListener((View.OnClickListener)  this);
        BecomeBtn.setOnClickListener((View.OnClickListener) this);
        SyllabusBtn.setOnClickListener((View.OnClickListener) this);
        ClassesBtn.setOnClickListener((View.OnClickListener) this);
        CollegesBtn.setOnClickListener((View.OnClickListener) this);
        NotesBtn.setOnClickListener((View.OnClickListener) this);
        ExamsBtn.setOnClickListener((View.OnClickListener) this);
        PapersBtn.setOnClickListener((View.OnClickListener) this);
        
        return myView;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.findbtn:
                startActivity(new Intent(getActivity(), FindTutor.class));
                break;
            case R.id.becomebtn:
                startActivity(new Intent(getActivity(), BecomeTutor.class));
                break;
            case R.id.syllabusbtn:
                startActivity(new Intent(getActivity(), SyllabusActivity.class));
                break;
            case R.id.collegesbtn:
                startActivity(new Intent(getActivity(), Colleges.class));
                break;
            case R.id.classbtn:
                startActivity(new Intent(getActivity(), Classes.class));
                break;
            case R.id.notesbtn:
                startActivity(new Intent(getActivity(), Notes.class));
                break;
            case R.id.paperbtn:
                startActivity(new Intent(getActivity(), QuestionPaper.class));
                break;
            case R.id.exambtn:
                startActivity(new Intent(getActivity(), ExamCourses.class));
                break;
        }
    }
}


