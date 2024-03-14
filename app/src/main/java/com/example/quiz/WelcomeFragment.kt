package com.example.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.quiz.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(inflater)
        return binding.root
    }
    //Функция, которая вызывается при создании нового экземпляра WelcomeFragment. В этой функции создается
    // и возвращается новый экземпляр FragmentWelcomeBinding.

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_quizFragment)
        }
    }
    //Функция, которая вызывается после того, как WelcomeFragment был создан и прикреплен к активности.
    // В этой функции устанавливается слушатель на кнопку с id button, который при нажатии перенаправляет
    // пользователя на QuizFragment.
}