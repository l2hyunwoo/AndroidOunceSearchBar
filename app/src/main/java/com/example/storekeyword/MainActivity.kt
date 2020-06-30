package com.example.storekeyword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.mancj.materialsearchbar.MaterialSearchBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lv = findViewById(R.id.mListView) as ListView
        val searchBar = findViewById<MaterialSearchBar>(R.id.searchBar)
        searchBar.setHint("Search")
        searchBar.setSpeechMode(false)

        var galaxies = arrayOf("Sombrero", "Cartwheel", "Pinwheel", "StarBust", "Whirlpool", "Ring Nebular", "Own Nebular", "Centaurus A", "Virgo Stellar Stream", "Canis Majos Overdensity", "Mayall's Object", "Leo", "Milky Way", "IC 1011", "Messier 81", "Andromeda", "Messier 87")

        //Adapter
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, galaxies)
        lv.visibility = View.INVISIBLE
        lv.setAdapter(adapter)
        searchBar.setOnSearchActionListener(object : MaterialSearchBar.OnSearchActionListener{
            override fun onButtonClicked(buttonCode: Int) {
                TODO("Not yet implemented")
            }

            override fun onSearchStateChanged(enabled: Boolean) {
                if(enabled){
                    lv.visibility = View.VISIBLE
                }else{
                    lv.visibility = View.INVISIBLE
                }
            }

            override fun onSearchConfirmed(text: CharSequence?) {
                TODO("Not yet implemented")
            }

        })

        searchBar.addTextChangeListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.getFilter().filter(s)
            }

        })


        lv.setOnItemClickListener(object : AdapterView.OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity, adapter.getItem(position)!!.toString(), Toast.LENGTH_SHORT).show()
            }

        })
    }

}