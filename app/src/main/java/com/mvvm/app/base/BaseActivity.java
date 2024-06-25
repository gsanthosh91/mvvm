package com.mvvm.app.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;

import org.jetbrains.annotations.NotNull;

/**
 *
 */

public abstract class BaseActivity<BINDING extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity implements IView {

    protected BINDING binding;
    protected VM viewModel;

    /**
     * ViewModel must be initialized before bindView() is called
     *
     * @param layout layout for the activity
     */

    @NonNull
    protected abstract VM createViewModel();

    @NonNull
    protected abstract BINDING createViewBinding(LayoutInflater layoutInflater);

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = createViewBinding(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        viewModel = createViewModel();
    }
/*

    protected final void bindView(int layout) {
        *//*if (viewModel == null) {
            throw new IllegalStateException("viewModel must not be null and should be injected via activityComponent().inject(this)");
        }*//*
        binding = DataBindingUtil.setContentView(this, layout);
    }*/

    @Override
    protected void onStop() {
        super.onStop();
        //viewModel.clearSubscriptions();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //viewModel.detach();
    }

    @Override
    public void onError(@NotNull Throwable throwable) {
        Toast.makeText(this, "Error called on BaseActivity", Toast.LENGTH_LONG).show();
    }
}
