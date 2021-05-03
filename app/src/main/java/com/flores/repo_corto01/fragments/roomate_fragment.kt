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
    //Pedro,M,15;Omar,M,20;Lupe,F,25;Rafael,M,22;Juana,F,23;Tomas,M,17

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

            roomateAge.forEach { age ->
                roomateAge.forEach{age2 ->
                    var conteaoAge = age.toInt() - age2.toInt()

                    //TODO: ARREGLAR EL RANGO DE EDAD (0-2)
                    if(conteaoAge == -2 or 0 &&
                        roomateSex[roomateAge.indexOf(age)] == roomateSex[roomateAge.indexOf(age2)])
                    {
                        var roomate1 = roomateName[roomateAge.indexOf(age)]
                        var roomate2 = roomateName[roomateAge.indexOf(age2)]
                        finalRoomates.add("$roomate1 y $roomate2")
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