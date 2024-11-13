package com.example.projeto.room

import androidx.lifecycle.LiveData
import com.example.projeto.room.dao.AlimentoDao
import com.example.projeto.room.dao.AlimentoUtilizadorDao
import com.example.projeto.room.dao.DiaDao
import com.example.projeto.room.dao.ExercicioDao
import com.example.projeto.room.dao.ExercicioUtilizadorDao
import com.example.projeto.room.dao.LivroDao
import com.example.projeto.room.dao.LivroUtilizadorDao
import com.example.projeto.room.dao.UtilizadorDao
import com.example.projeto.room.entities.Alimento
import com.example.projeto.room.entities.AlimentoUtilizador
import com.example.projeto.room.entities.Dia
import com.example.projeto.room.entities.Exercicio
import com.example.projeto.room.entities.ExercicioUtilizador
import com.example.projeto.room.entities.Livro
import com.example.projeto.room.entities.LivroUtilizador
import com.example.projeto.room.entities.Utilizador

class AppRepository(
    private val utilizadorDao: UtilizadorDao,
    private val livroDao: LivroDao,
    private val livroUtilizadorDao: LivroUtilizadorDao,
    private val exercicioDao: ExercicioDao,
    private val exercicioUtilizadorDao: ExercicioUtilizadorDao,
    private val alimentoDao: AlimentoDao,
    private val alimentoUtilizadorDao: AlimentoUtilizadorDao,
    private val diaDao: DiaDao
) {

    // Funções do AlimentoDao
    suspend fun insertAlimento(alimento: Alimento) {
        alimentoDao.insert(alimento)
    }

    suspend fun updateAlimento(alimento: Alimento) {
        alimentoDao.update(alimento)
    }

    suspend fun deleteAlimento(alimento: Alimento) {
        alimentoDao.delete(alimento)
    }

    fun getAlimentoById(id: Int): Alimento? {
        return alimentoDao.getById(id)
    }

    fun getAllAlimentos(): LiveData<List<Alimento>> {
        return alimentoDao.getAll()
    }

    // Funções do AlimentoUtilizadorDao
    suspend fun insertAlimentoUtilizador(alimentoUtilizador: AlimentoUtilizador) {
        alimentoUtilizadorDao.insert(alimentoUtilizador)
    }

    suspend fun deleteAlimentoUtilizador(alimentoUtilizador: AlimentoUtilizador) {
        alimentoUtilizadorDao.delete(alimentoUtilizador)
    }

    fun getAlimentosByUserId(userId: Int): LiveData<List<AlimentoUtilizador>> {
        return alimentoUtilizadorDao.getByUserId(userId)
    }

    fun getAlimentosByAlimentoId(alimentoId: Int): LiveData<List<AlimentoUtilizador>> {
        return alimentoUtilizadorDao.getByAlimentoId(alimentoId)
    }

    // Funções do DiaDao
    suspend fun insertDia(dia: Dia) {
        diaDao.insert(dia)
    }

    suspend fun updateDia(dia: Dia) {
        diaDao.update(dia)
    }

    suspend fun deleteDia(dia: Dia) {
        diaDao.delete(dia)
    }

    fun getDiaById(data: String, userId: Int): Dia? {
        return diaDao.getById(data, userId)
    }

    fun getAllDias(): LiveData<List<Dia>> {
        return diaDao.getAll()
    }

    // Funções do ExercicioDao
    suspend fun insertExercicio(exercicio: Exercicio) {
        exercicioDao.insert(exercicio)
    }

    suspend fun updateExercicio(exercicio: Exercicio) {
        exercicioDao.update(exercicio)
    }

    suspend fun deleteExercicio(exercicio: Exercicio) {
        exercicioDao.delete(exercicio)
    }

    fun getIndoorExercicioById(id: Int): Exercicio? {
        return exercicioDao.getIndoorById(id)
    }

    fun getOutdoorExercicioById(id: Int): Exercicio? {
        return exercicioDao.getOutdoorById(id)
    }

    fun getAllIndoorExercicios(): LiveData<List<Exercicio>> {
        return exercicioDao.getAllIndoor()
    }

    fun getAllOutdoorExercicios(): LiveData<List<Exercicio>> {
        return exercicioDao.getAllOutdoor()
    }

    // Funções do ExercicioUtilizadorDao
    suspend fun insertExercicioUtilizador(exercicioUtilizador: ExercicioUtilizador) {
        exercicioUtilizadorDao.insert(exercicioUtilizador)
    }

    suspend fun deleteExercicioUtilizador(exercicioUtilizador: ExercicioUtilizador) {
        exercicioUtilizadorDao.delete(exercicioUtilizador)
    }

    fun getExercicioUtilizadoresByUserId(userId: Int): LiveData<List<ExercicioUtilizador>> {
        return exercicioUtilizadorDao.getByUserId(userId)
    }

    fun getExercicioUtilizadoresByExercicioId(exercicioId: Int): LiveData<List<ExercicioUtilizador>> {
        return exercicioUtilizadorDao.getByExercicioId(exercicioId)
    }

    // Funções do LivroDao
    suspend fun insertLivro(livro: Livro) {
        livroDao.insert(livro)
    }

    suspend fun updateLivro(livro: Livro) {
        livroDao.update(livro)
    }

    suspend fun deleteLivro(livro: Livro) {
        livroDao.delete(livro)
    }

    fun getLivroById(id: Int): Livro? {
        return livroDao.getById(id)
    }

    fun getAllLivros(): LiveData<List<Livro>> {
        return livroDao.getAll()
    }

    // Funções do LivroUtilizadorDao
    suspend fun insertLivroUtilizador(livroUtilizador: LivroUtilizador) {
        livroUtilizadorDao.insert(livroUtilizador)
    }

    suspend fun deleteLivroUtilizador(livroUtilizador: LivroUtilizador) {
        livroUtilizadorDao.delete(livroUtilizador)
    }

    fun getLivrosByUserId(userId: Int): LiveData<List<LivroUtilizador>> {
        return livroUtilizadorDao.getByUserId(userId)
    }

    fun getLivrosByLivroId(livroId: Int): LiveData<List<LivroUtilizador>> {
        return livroUtilizadorDao.getByLivroId(livroId)
    }

    // Funções do UtilizadorDao
    suspend fun insertUtilizador(utilizador: Utilizador) {
        utilizadorDao.insert(utilizador)
    }

    suspend fun updateUtilizador(utilizador: Utilizador) {
        utilizadorDao.update(utilizador)
    }

    suspend fun deleteUtilizador(utilizador: Utilizador) {
        utilizadorDao.delete(utilizador)
    }

    fun getUtilizadorById(id: Int): Utilizador? {
        return utilizadorDao.getById(id)
    }

    fun getUtilizadorByEmail(email: String): Utilizador? {
        return utilizadorDao.getByEmail(email)
    }

    fun getAllUtilizadores(): LiveData<List<Utilizador>> {
        return utilizadorDao.getAll()
    }
}
