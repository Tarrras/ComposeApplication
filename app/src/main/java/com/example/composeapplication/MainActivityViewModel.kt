package com.example.composeapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    private val dataList: MutableLiveData<ArrayList<ProgramModel>> = MutableLiveData<ArrayList<ProgramModel>>().apply { value = ArrayList() }

    fun getData(): LiveData<ArrayList<ProgramModel>>{
        return dataList
    }

    fun fetchData(){
        val temp = ArrayList<ProgramModel>()
        temp.add(ProgramModel("Washington",R.drawable.washington))
        temp.add(ProgramModel("Moscow",R.drawable.moscow))
        temp.add(ProgramModel("Kyiv",R.drawable.kyiv))
        temp.add(ProgramModel("London",R.drawable.london))
        temp.add(ProgramModel("Paris",R.drawable.paris))
        temp.add(ProgramModel("Madrid"))

        dataList.postValue(temp)
    }


}