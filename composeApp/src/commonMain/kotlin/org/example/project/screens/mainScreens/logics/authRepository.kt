package org.example.project.screens.mainScreens.logics
//
//import dev.gitlive.firebase.Firebase
//import dev.gitlive.firebase.auth.FirebaseAuth
//import dev.gitlive.firebase.auth.auth
//
//class AuthRepository {
//    private val auth: FirebaseAuth = Firebase.auth
//
//    suspend fun registerUser(email: String, pasword: String): Result<String> {
//        return try {
//            val result = auth.createUserWithEmailAndPassword(email, pasword)
//            Result.success(result.user?.uid ?: "No UID found")
//        } catch (e: Exception) {
//            Result.failure(e)
//        }
//    }
//
//    fun isUserLoggedIn(): Boolean {
//        return auth.currentUser != null
//    }
//
//    suspend fun logOutUser() {
//        auth.signOut()
//    }
//}