/*
 * This file is protected under the KILLGPL.
 * For more information visit <insert_valid_link_to_killgpl_here>
 * <p/>
 * Copyright (c) Luke A. Leber <LukeLeber@gmail.com> 2015
 */

package com.lukeleber.scandroid.gui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lukeleber.scandroid.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResetDiagnosticInformation
        extends ServiceFragment
{

    @OnClick(R.id.reset_diagnostic_information)
    void onResetDiagnosticsClicked()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rv = inflater.inflate(R.layout.fragment_reset_diagnostic_information, container,
                                   false);
        ButterKnife.inject(this, rv);
        return rv;
    }

}
