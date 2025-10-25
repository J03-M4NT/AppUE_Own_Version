package com.example.appue.data.remote.firebase

import android.R.attr.name
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object FirebaseAuthManager {

    // This way works to connect the credentials to the firebase auth

    private val auth = FirebaseAuth.getInstance()
    private val firestore = FirebaseFirestore.getInstance()


    // Register user function
    suspend fun registerUser(name: String, email: String, password: String): Result<Unit> {

        return try {
            // Firebase auth
            val authResult = auth
                .createUserWithEmailAndPassword(email, password).await()

            val uid = authResult.user?.uid ?: throw Exception("User ID is null")
            Result.success(Unit)

            // Firebase Firestore  --  Add the user to the database
            val user = hashMapOf("name" to name, "email" to email, "uid" to uid)
            firestore
                .collection("users")
                .document(uid)
                .set(user)                              // I give the complete user
                .await()

            Result.success(Unit)


        } catch (e: Exception) {
            Result.failure(e)
        }

    }


    // Login user function
    suspend fun loginuser(email: String, password: String): Result<Unit> {

        return try {
            auth.signInWithEmailAndPassword(email, password).await()
            Result.success(Unit)

        } catch (e: Exception) {
            Result.failure(e)
        }

    }

    // Close actual session
    fun logout(){
        auth.signOut()
    }


    // *********


}