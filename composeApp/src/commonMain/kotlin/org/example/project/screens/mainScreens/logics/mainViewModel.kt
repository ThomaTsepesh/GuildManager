package org.example.project.screens.mainScreens.logics
//
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//
//class MainViewModel(private val repository: AuthRepository){
//    private val _registrationState = MutableStateFlow<RegistrationState>(RegistrationState.Idle)
//    val registrationState: StateFlow<RegistrationState> = _registrationState
//
//    fun register(email: String, password: String){
//        _registrationState.value = RegistrationState.Loading
//
//        CoroutineScope(Dispatchers.Main).launch {
//            val result = repository.registerUser(email, password)
//            _registrationState.value = result.fold(
//                onSuccess = {RegistrationState.Success(it) },
//                onFailure = {RegistrationState.Error(it.message ?: "Unknown error")}
//            )
//        }
//    }
//}
//
//sealed class RegistrationState {
//    object Idle : RegistrationState()
//    object Loading : RegistrationState()
//    data class Success(val uid: String) : RegistrationState()
//    data class Error(val message: String) : RegistrationState()
//}
