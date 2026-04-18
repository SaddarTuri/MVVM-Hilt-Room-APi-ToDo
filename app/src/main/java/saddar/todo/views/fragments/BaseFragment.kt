package saddar.todo.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

abstract class BaseFragment : Fragment() {

    private var mPreviousView: View? = null

    @LayoutRes
    abstract fun getLayoutResId(): Int

    abstract fun onCreateView(
        mRootView: ViewGroup, savedInstanceState: Bundle?
    )

    open fun themeInflater(baseInflater: LayoutInflater): LayoutInflater? = null

    open fun initializeView(view: View) {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        mPreviousView?.let { return it }
        val newInflater = themeInflater(inflater) ?: inflater
        val mView = newInflater.inflate(getLayoutResId(), container, false)
        initializeView(mView)

        onCreateView(mView as ViewGroup, savedInstanceState)
        return mView.also {
            mPreviousView = it
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    protected fun <T, LD : LiveData<T>> observe(liveData: LD, onChanged: (T) -> Unit) {
        liveData.observe(this, Observer {
            it?.let(onChanged)
        })
    }


}