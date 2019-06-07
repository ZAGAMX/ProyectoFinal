package com.example.cantu.proyectofinalpma.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.cantu.proyectofinalpma.Carp_Directorio.directorioInstalaciones;
import com.example.cantu.proyectofinalpma.Carp_Directorio.directorioMaestro;
import com.example.cantu.proyectofinalpma.R;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Directorio.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Directorio#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Directorio extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    CardView cardView;
    CardView cardView2;

    FrameLayout seller, buyer;
    View view1, view2;
    TextView tvseller, tvbuyer;

    public Directorio() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment Directorio.
     */
    // TODO: Rename and change types and number of parameters
    public static Directorio newInstance() {
        Directorio fragment = new Directorio();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Directorio");
        View view = inflater.inflate(R.layout.fragment_directorio, container, false);
        init(view);
        seller.setOnClickListener(clik);
        buyer.setOnClickListener(clik);
        //LOAD PAGE FOR FIRST
        loadPage(new directorioMaestro());
        /*cardView = view.findViewById(R.id.card_view);
        cardView2 = view.findViewById(R.id.card_view2);





        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), recycler.class);
                i.putExtra("instala","0");
                startActivity(i);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), recycler.class);
                i.putExtra("instala","1");
                startActivity(i);
            }
        });*/

        return view;
    }

    //ONCLICK LISTENER
    public View.OnClickListener clik = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.seller:
                    //ONSELLER CLICK
                    //LOAD SELLER FRAGMENT CLASS
                    loadPage(new directorioMaestro());
                    //WHEN CLICK TEXT COLOR CHANGED
                    tvseller.setTextColor(getActivity().getResources().getColor(R.color.colorPrimary));
                    tvbuyer.setTextColor(getActivity().getResources().getColor(R.color.colorAccent));
                    //VIEW VISIBILITY WHEN CLICKED
                    view1.setVisibility(View.VISIBLE);
                    view2.setVisibility(View.INVISIBLE);
                    break;
                case R.id.buyer:
                    //ONBUYER CLICK
                    //LOAD BUYER FRAGMENT CLASS
                    loadPage(new directorioInstalaciones());

                    //WHEN CLICK TEXT COLOR CHANGED
                    tvseller.setTextColor(getActivity().getResources().getColor(R.color.colorAccent));
                    tvbuyer.setTextColor(getActivity().getResources().getColor(R.color.colorPrimary));
                    //VIEW VISIBILITY WHEN CLICKED
                    view1.setVisibility(View.INVISIBLE);
                    view2.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    public void init(View v){
        seller = v.findViewById(R.id.seller);
        buyer = v.findViewById(R.id.buyer);
        view1 = v.findViewById(R.id.view1);
        view2 = v.findViewById(R.id.view2);
        tvseller = v.findViewById(R.id.tvseller);
        tvbuyer = v.findViewById(R.id.tvbuyer);
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    private boolean loadPage(Fragment fragment) {
        if (fragment != null) {
            Objects.requireNonNull(getActivity()).getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.containerpage, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
