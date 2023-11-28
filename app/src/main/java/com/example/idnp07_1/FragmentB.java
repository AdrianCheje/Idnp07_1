package com.example.idnp07_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.idnp07_1.MainActivity;

public class FragmentB extends Fragment {
    private EditText editText;
    private Button sendButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        editText = view.findViewById(R.id.editText);
        sendButton = view.findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                ((MainActivity) requireActivity()).sendMessageToFragmentA(message);
            }
        });

        return view;
    }
    public void displayReceivedMessage(String message) {
        editText.setText(message);
    }
}

