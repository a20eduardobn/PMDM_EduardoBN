package com.example.ud05_1_pizza

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class OrderFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_order,container,false)
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        val floatbutton = view.findViewById<FloatingActionButton>(R.id.fab_add)
        floatbutton.setOnClickListener {
            val pizzaGroup = view.findViewById<RadioGroup>(R.id.group_pizza)
            val pizzaType = pizzaGroup.checkedRadioButtonId
            var msg = ""
            if (pizzaType==-1){
                msg= "Debes seleccionar un tipo de pizza"
            } else {
                msg = when(pizzaType){
                    R.id.radio_margarita -> "Margarita"
                    else -> "Calzone"
                }
                //Extras
                var parmesano = view.findViewById<Chip>(R.id.chip_parmesano)
                if (parmesano.isChecked)  msg+= " con parmesano"
                var cherry = view.findViewById<Chip>(R.id.chip_tomate_chery)
                if (cherry.isChecked)  msg+= " con tomate cherry"
                var atun = view.findViewById<Chip>(R.id.chip_Atun)
                if (atun.isChecked)  msg+= " con atun"
                var mozzarella = view.findViewById<Chip>(R.id.chip_mozzarella)
                if (mozzarella.isChecked)  msg+= " con mozzarella"
            }
            //Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
            val snackbar = Snackbar.make(floatbutton, msg, Snackbar.LENGTH_SHORT)
            snackbar.setAction("Undo"){
                pizzaGroup.clearCheck();
            }
            snackbar.show()
        }


        return view
    }

}