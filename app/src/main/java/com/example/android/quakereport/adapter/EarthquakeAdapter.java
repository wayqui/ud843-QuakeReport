package com.example.android.quakereport.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.quakereport.R;
import com.example.android.quakereport.dataobject.Earthquake;


import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by joselobm on 19/08/17.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake>{

    public EarthquakeAdapter(Context context, List<Earthquake> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_item_layout, parent, false);
        }

        // Obtener el objeto en la posición actual
        final Earthquake objEarthquake = getItem(position);

        // Informar a los distintos componentes los valores del objeto obtenido
        TextView tvMagnitud = (TextView) listItemView.findViewById(R.id.tvMagnitud);
        tvMagnitud.setText(objEarthquake.getMagnitud().toString());

        GradientDrawable magnitudeCircle = (GradientDrawable) tvMagnitud.getBackground();
        int magnitudeColor = getMagnitudeColor(objEarthquake.getMagnitud());
        magnitudeCircle.setColor(magnitudeColor);

        TextView tvLocalizacion = (TextView) listItemView.findViewById(R.id.tvLocalizacion);
        tvLocalizacion.setText(objEarthquake.obtenerUbicacionSeparada()[0]);

        TextView tvUbicacion = (TextView) listItemView.findViewById(R.id.tvUbicacion);
        tvUbicacion.setText(objEarthquake.obtenerUbicacionSeparada()[1]);

        TextView tvFecha = (TextView) listItemView.findViewById(R.id.tvFecha);
        tvFecha.setText(objEarthquake.getFechaComoString());

        TextView tvHora = (TextView) listItemView.findViewById(R.id.tvHora);
        tvHora.setText(objEarthquake.getHoraComoString());

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentWebsite = new Intent();
                intentWebsite.setAction(Intent.ACTION_VIEW);
                intentWebsite.setData(Uri.parse(objEarthquake.getUrlWebsite()));
                getContext().startActivity(intentWebsite);
            }
        });

        // devolver el listview
        return listItemView;

    }

    private int getMagnitudeColor(Float magnitud) {
        int magnitudeColorResourceId;
        switch (magnitud.intValue()) {
            case 0:
                case 1:
                    magnitudeColorResourceId = R.color.magnitude1;
                    break;
                case 2:
                    magnitudeColorResourceId = R.color.magnitude2;
                    break;
                case 3:
                    magnitudeColorResourceId = R.color.magnitude3;
                    break;
                case 4:
                    magnitudeColorResourceId = R.color.magnitude4;
                    break;
                case 5:
                    magnitudeColorResourceId = R.color.magnitude5;
                    break;
                case 6:
                    magnitudeColorResourceId = R.color.magnitude6;
                    break;
                case 7:
                    magnitudeColorResourceId = R.color.magnitude7;
                    break;
                case 8:
                    magnitudeColorResourceId = R.color.magnitude8;
                    break;
                case 9:
                    magnitudeColorResourceId = R.color.magnitude9;
                    break;
                default:
                    magnitudeColorResourceId = R.color.magnitude10plus;
                    break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

}
