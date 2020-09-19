package com.soniacruz.mismascotasbd;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.soniacruz.mismascotasbd.mailsenderactivity.SendMailTask;

import java.util.Arrays;
import java.util.List;

public class Contact extends AppCompatActivity {

    private AppCompatEditText etx_nombre;
    private AppCompatEditText etx_email;
    private AppCompatEditText etx_comentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionBarContact);
        setSupportActionBar(miActionBar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        // Habilita el botón Subir
        ab.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setIcon(R.drawable.ic_footprint);


        Button btnSend = (Button) findViewById(R.id.btnSend);

        etx_nombre = (AppCompatEditText) findViewById(R.id.etx_nombre);
        etx_email = (AppCompatEditText) findViewById(R.id.etx_email);
        etx_comentario = (AppCompatEditText) findViewById(R.id.etx_comentario);



        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarFormContacto())
                {
                    String nombre = etx_nombre.getText().toString();
                    String email = etx_email.getText().toString();
                    String comentario = etx_comentario.getText().toString();

                    //Datos de la cuenta desde la que se envia el correo
                    String gmail_address    = "sonyct568319@gmail.com";
                    String gmail_password   = "eanuCSUBDDstd356";

                    String asunto           = getString(R.string.subject);
                    String mensaje = nombre + " "+getString(R.string.commented)+": " + "\n" + comentario;
                    List<String> toEmailList = Arrays.asList(email.split("\\s*,\\s*"));

                    new SendMailTask(Contact.this).execute(gmail_address, gmail_password, toEmailList, asunto, mensaje);



                }
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide slide = new Slide(Gravity.LEFT);
            slide.setDuration(1200);
            getWindow().setEnterTransition(slide);
            getWindow().setReturnTransition(new Fade(Fade.OUT));

        }

    }
    /*
    Método para posicionarte en el EditText donde este el error
     */
    public void establecerFocus(View v)
    {
        if(v.requestFocus())
        {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    /*
    Método para validar que los campos contengan datos( no vacios ) y un minimo de caracteres
     */
    public boolean validarFormContacto() {
        //Valida que el nombre no esté vacío y tenga al menos 3 caracteres
        if(etx_nombre.getText().toString().trim().isEmpty())
        {
            etx_nombre.setError(getString(R.string.error_blank)+" "+getString(R.string.form_nombre));
            establecerFocus(etx_nombre);
            return false;
        }
        else if(etx_nombre.getText().toString().trim().length()<3)
        {
            etx_nombre.setError(getString(R.string.minimo)+" 3 "+getString(R.string.caracteres));
            establecerFocus(etx_nombre);
            return false;
        }
        //Valida que el email no esté vacío y tenga al menos 11 caracteres
        if(etx_email.getText().toString().trim().isEmpty())
        {
            etx_email.setError(getString(R.string.error_blank)+" "+getString(R.string.form_email));
            establecerFocus(etx_email);
            return false;
        }else if(etx_email.getText().toString().trim().length()<11)
        {
            etx_email.setError(getString(R.string.minimo)+" 11 "+getString(R.string.caracteres));
            establecerFocus(etx_email);
            return false;
        }
        //Valida que el comentario no esté vacío y tenga al menos 2 caracteres
        if(etx_comentario.getText().toString().trim().isEmpty())
        {
            etx_comentario.setError(getString(R.string.error_blank)+" "+getString(R.string.form_comentario));
            establecerFocus(etx_comentario);
            return false;
        }else if(etx_comentario.getText().toString().trim().length()<2)
        {
            etx_comentario.setError(getString(R.string.minimo)+" 2 "+getString(R.string.caracteres));
            establecerFocus(etx_comentario);
            return false;
        }
        return true;
    }

}