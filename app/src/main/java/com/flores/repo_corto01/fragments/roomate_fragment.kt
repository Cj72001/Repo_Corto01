package com.flores.repo_corto01.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.flores.repo_corto01.R

class RoomateFragment:Fragment(){
    //EJ:
    //Pedro,M,15;Omar,M,20;Lupe,F,25;Rafael,M,22;Juana,F,24;Tomas,M,15

    private var roomate = mutableListOf<String>()
    private var roomates = mutableListOf<String>()
    private var roomateName = mutableListOf<String>()
    private var roomateSex = mutableListOf<String>()
    private var roomateAge = mutableListOf<String>()
    private var finalRoomates = mutableListOf<String>()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.roommate_fragment, container, false)

        var alumnoBox = view.findViewById<TextView>(R.id.input_roomate_text_edit)
        var textViewParejas = view.findViewById<TextView>(R.id.parejas_text_view)

        val btnAgregar = view.findViewById<Button>(R.id.action_agregar)
        val btnMostrar = view.findViewById<Button>(R.id.action_mostrar)
        val btnLimpiar = view.findViewById<Button>(R.id.action_limpiar)


        btnAgregar.setOnClickListener {
            if(alumnoBox.text.contains(';'))
            {
                roomates = alumnoBox.text.split(';').toMutableList()
                roomates.forEach { roomateVar ->
                    roomate = roomateVar.split(',').toMutableList()
                    splitRoomatesData()
                }
            }

            else{
                roomate = alumnoBox.text.split(',').toMutableList()
                splitRoomatesData()
            }
        }

        btnMostrar.setOnClickListener{

            val rangoDiferencia = -2..2

            for (ageIndex in 0..roomateAge.size-1)
            {
                for(age2Index in 0..roomateAge.size-1)
                {
                    var age1:Int = roomateAge[ageIndex].toInt()
                    var age2:Int = roomateAge[age2Index].toInt()
                    var conteaoAge = age1-age2


                    if(conteaoAge in rangoDiferencia && roomateSex[ageIndex] == roomateSex[age2Index] && ageIndex != age2Index)
                    {
                        var roomate1 = roomateName[ageIndex]
                        var roomate2 = roomateName[age2Index]

                        if(!finalRoomates.contains("$roomate1 y $roomate2") && !finalRoomates.contains("$roomate2 y $roomate1"))
                        {
                            finalRoomates.add("$roomate1 y $roomate2")
                        }
                    }
                }
            }


            var string = ""
            string += "Parejas: \n"
            finalRoomates.forEach { nombre->
                string += "$nombre \n"
            }

            textViewParejas.text = string

        }


        btnLimpiar.setOnClickListener{
            roomate.clear()
             roomate.clear()
             roomates.clear()
            roomateName.clear()
            roomateSex.clear()
            roomateAge.clear()
            finalRoomates.clear()
            textViewParejas.text=""
            alumnoBox.text=""
        }

        return view;
    }


    fun splitRoomatesData (){

        val constantIndex = 0

        roomateName.add(roomate[constantIndex])
        roomate.removeAt(constantIndex)

        roomateSex.add(roomate[constantIndex])
        roomate.removeAt(constantIndex)

        roomateAge.add(roomate[constantIndex])
        roomate.removeAt(constantIndex)

    }


    companion object {

        fun newInstance() = RoomateFragment().apply {
            arguments = Bundle().apply {
            }
        }
    }

}