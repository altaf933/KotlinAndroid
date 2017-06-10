package quock.kotlinfirstapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mutableList: MutableList<Data> = mutableListOf();
        for(i in 1 until 10){
            mutableList.add(Data("Abu ${i}","Engineer"));
        }


        with(rclView){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity);
            var mainAdapter = DataAdapter(mutableList)
            adapter = mainAdapter;
        }

    }

}
