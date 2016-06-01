package android.android.app.com.avanceproductomaria;

import android.android.app.com.avanceproductomaria.adapter.recyclerview.RVAdapterProductoFirst;
import android.android.app.com.avanceproductomaria.adapter.recyclerview.dao.DAProducto;
import android.android.app.com.avanceproductomaria.adapter.recyclerview.dao.DataBaseHelper;
import android.android.app.com.avanceproductomaria.adapter.recyclerview.dao.DataBaseSingleton;
import android.android.app.com.avanceproductomaria.adapter.recyclerview.interfaces.IRVProductoAdapter;
import android.android.app.com.avanceproductomaria.entities.BEProducto;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;

/**
 * Created by Alejandra on 01/06/2016.
 */
public class ListaProductoActivity extends AppCompatActivity implements IRVProductoAdapter {

    private RecyclerView rvFirstActivity;
    private RVAdapterProductoFirst mRVAdapterProductoFirst ;
    private Toolbar tbFirstProductoActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_producto_activity);

        rvFirstActivity = (RecyclerView) findViewById(R.id.rvFirstProductoActivity);
        tbFirstProductoActivity = (Toolbar) findViewById(R.id.tbFirstProductoActivity);
        setSupportActionBar(tbFirstProductoActivity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rvFirstActivity.setLayoutManager(new LinearLayoutManager(ListaProductoActivity.this));

        mRVAdapterProductoFirst = new RVAdapterProductoFirst(ListaProductoActivity.this);
        rvFirstActivity.setHasFixedSize(true);
        rvFirstActivity.setAdapter(mRVAdapterProductoFirst);

        DataBaseHelper dbHelper = new DataBaseHelper(ListaProductoActivity.this);
        try {
            dbHelper.createDataBase();
            new DataBaseSingleton(ListaProductoActivity.this);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        mRVAdapterProductoFirst.clearAndAddAll(new DAProducto().listaProducto());
    }



    @Override
    public void onSelectItem(BEProducto producto) {
        Intent intent = new Intent(ListaProductoActivity.this, DetalleProductoActivity.class);
        intent.putExtra(DetalleProductoActivity.ARG_DETALLE_PRODUCTO, producto);
        startActivity(intent);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lista_producto,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }else if (item.getItemId() == R.id.menuCrearProducto){
            Intent intent = new Intent(ListaProductoActivity.this, CrearEditProductoActivity.class);
            startActivity(intent);
        }

        return true;
    }


}
