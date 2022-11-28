package com.lutfullayevmuhammad.quran.ui.homeimport android.util.Logimport androidx.lifecycle.MutableLiveDataimport androidx.lifecycle.ViewModelimport com.lutfullayevmuhammad.quran.core.helper.ResultWrapperimport com.lutfullayevmuhammad.quran.core.models.error.UniversalErrorimport com.lutfullayevmuhammad.quran.core.models.sura.SuraResponseimport com.lutfullayevmuhammad.quran.core.repo.HomeRepoimport kotlinx.coroutines.CoroutineScopeimport kotlinx.coroutines.Dispatchersimport kotlinx.coroutines.launchimport javax.inject.Injectclass HomeViewModel @Inject constructor(    var repo: HomeRepo) : ViewModel() {    val homeListLiveData = MutableLiveData<SuraResponse>()    val errorLiveData = MutableLiveData<UniversalError?>()    val networkErrorLiveData = MutableLiveData<Nothing>()    fun suraList(language: String) {        CoroutineScope(Dispatchers.IO).launch {            val response = repo.suraData(language)            when (response) {                is ResultWrapper.Success -> {                    homeListLiveData.postValue(response.response!!)                }                is ResultWrapper.ErrorResponse -> {                    errorLiveData.postValue(response.errorResponse)                }                is ResultWrapper.NetworkError -> {                    networkErrorLiveData.postValue(null)                }            }        }    }    override fun onCleared() {        Log.d("MainViewModelTAG", "onCleared: ")        super.onCleared()    }}