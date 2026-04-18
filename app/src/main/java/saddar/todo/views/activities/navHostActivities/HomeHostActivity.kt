package saddar.todo.views.activities.navHostActivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import saddar.todo.R
import saddar.todo.databinding.ActivityHomeHostBinding
import saddar.todo.views.activities.baseActivity.BaseActivity

@AndroidEntryPoint
class HomeHostActivity : BaseActivity() {

    lateinit var binding: ActivityHomeHostBinding

    private var navController: NavController? = null
    private var navHostFragment: NavHostFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeHostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.home_host_fragment_id) as NavHostFragment
        navController = navHostFragment!!.navController
    }
}