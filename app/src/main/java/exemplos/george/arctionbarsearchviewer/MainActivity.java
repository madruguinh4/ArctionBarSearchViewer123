package exemplos.george.arctionbarsearchviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = (ListView)findViewById(R.id.ListViewCountry);
        ArrayList<String> arrayCountry = new ArrayList<>();
        arrayCountry.addAll(Arrays.asList(getResources().getStringArray(R.array.array_country)));

        adapter = new ArrayAdapter<>(
                MainActivity.this, android.R.layout.simple_list_item_1,
                arrayCountry);
        lv.setAdapter(adapter);

    }

    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            public boolean onQueryTextSubmit (String query){
                return false;
            }

            public boolean onQueryTextChange(String newText){
                adapter.getFilter().filter(newText);

                 return false;

        }
        } );

        return super.onCreateOptionsMenu(menu);

    }




}
