import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.projeto.room.AppDatabase
import com.example.projeto.room.AppRepository
import com.example.projeto.room.entities.Alimento
import com.example.projeto.room.entities.AlimentoUtilizador
import com.example.projeto.room.entities.Dia
import com.example.projeto.room.entities.Exercicio
import com.example.projeto.room.entities.ExercicioUtilizador
import com.example.projeto.room.entities.Livro
import com.example.projeto.room.entities.LivroUtilizador
import com.example.projeto.room.entities.Utilizador
import kotlinx.coroutines.launch

class AppViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: AppRepository
    val allUtilizadores: LiveData<List<Utilizador>>
    val allLivros: LiveData<List<Livro>>
    val allExerciciosIndoor: LiveData<List<Exercicio>>
    val allExerciciosOutdoor: LiveData<List<Exercicio>>
    val allAlimentos: LiveData<List<Alimento>>
    val allDias: LiveData<List<Dia>>
    val userId = 0

    init {
        val database = AppDatabase.getDatabase(application)
        repository = AppRepository(
            database.utilizadorDao(),
            database.livroDao(),
            database.livroUtilizadorDao(),
            database.exercicioDao(),
            database.exercicioUtilizadorDao(),
            database.alimentoDao(),
            database.alimentoUtilizadorDao(),
            database.diaDao()
        )

        allUtilizadores = repository.getAllUtilizadores()
        allLivros = repository.getAllLivros()
        allExerciciosIndoor = repository.getAllIndoorExercicios()
        allExerciciosOutdoor = repository.getAllOutdoorExercicios()
        allAlimentos = repository.getAllAlimentos()
        allDias = repository.getAllDias()
    }

    fun insertUtilizador(utilizador: Utilizador) {
        viewModelScope.launch {
            repository.insertUtilizador(utilizador)
        }
    }

    fun insertLivro(livro: Livro) {
        viewModelScope.launch {
            repository.insertLivro(livro)
        }
    }

    fun insertExercicio(exercicio: Exercicio) {
        viewModelScope.launch {
            repository.insertExercicio(exercicio)
        }
    }

    fun insertAlimento(alimento: Alimento) {
        viewModelScope.launch {
            repository.insertAlimento(alimento)
        }
    }

    fun insertDia(dia: Dia) {
        viewModelScope.launch {
            repository.insertDia(dia)
        }
    }

    fun insertExercicioUtilizador(exercicioUtilizador: ExercicioUtilizador) {
        viewModelScope.launch {
            repository.insertExercicioUtilizador(exercicioUtilizador)
        }
    }

    fun insertAlimentoUtilizador(alimentoUtilizador: AlimentoUtilizador) {
        viewModelScope.launch {
            repository.insertAlimentoUtilizador(alimentoUtilizador)
        }
    }

    fun insertLivroUtilizador(livroUtilizador: LivroUtilizador) {
        viewModelScope.launch {
            repository.insertLivroUtilizador(livroUtilizador)
        }
    }

    fun updateUtilizador(utilizador: Utilizador) {
        viewModelScope.launch {
            repository.updateUtilizador(utilizador)
        }
    }

    fun updateLivro(livro: Livro) {
        viewModelScope.launch {
            repository.updateLivro(livro)
        }
    }

    fun updateExercicio(exercicio: Exercicio) {
        viewModelScope.launch {
            repository.updateExercicio(exercicio)
        }
    }

    fun updateAlimento(alimento: Alimento) {
        viewModelScope.launch {
            repository.updateAlimento(alimento)
        }
    }

    fun updateDia(dia: Dia) {
        viewModelScope.launch {
            repository.updateDia(dia)
        }
    }

    fun deleteUtilizador(utilizador: Utilizador) {
        viewModelScope.launch {
            repository.deleteUtilizador(utilizador)
        }
    }

    fun deleteLivro(livro: Livro) {
        viewModelScope.launch {
            repository.deleteLivro(livro)
        }
    }

    fun deleteExercicio(exercicio: Exercicio) {
        viewModelScope.launch {
            repository.deleteExercicio(exercicio)
        }
    }

    fun deleteAlimento(alimento: Alimento) {
        viewModelScope.launch {
            repository.deleteAlimento(alimento)
        }
    }

    fun deleteDia(dia: Dia) {
        viewModelScope.launch {
            repository.deleteDia(dia)
        }
    }

    fun deleteExercicioUtilizador(exercicioUtilizador: ExercicioUtilizador) {
        viewModelScope.launch {
            repository.deleteExercicioUtilizador(exercicioUtilizador)
        }
    }

    fun deleteLivroUtilizador(livroUtilizador: LivroUtilizador) {
        viewModelScope.launch {
            repository.deleteLivroUtilizador(livroUtilizador)
        }
    }

    fun deleteAlimentoUtilizador(alimentoUtilizador: AlimentoUtilizador) {
        viewModelScope.launch {
            repository.deleteAlimentoUtilizador(alimentoUtilizador)
        }
    }

    fun getUtilizadorById(id: Int): Utilizador? {
        return repository.getUtilizadorById(id)
    }

    fun getUtilizadorByEmail(email: String): Utilizador? {
        return repository.getUtilizadorByEmail(email)
    }

    fun getLivroById(id: Int): Livro? {
        return repository.getLivroById(id)
    }

    fun getExercicioIndoorById(id: Int): Exercicio? {
        return repository.getIndoorExercicioById(id)
    }

    fun getExercicioOutdoorById(id: Int): Exercicio? {
        return repository.getOutdoorExercicioById(id)
    }

    fun getAlimentoById(id: Int): Alimento? {
        return repository.getAlimentoById(id)
    }

}
