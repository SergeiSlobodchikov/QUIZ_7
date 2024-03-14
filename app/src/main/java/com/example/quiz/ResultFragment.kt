package com.example.quiz

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.quiz.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private val args: ResultFragmentArgs by navArgs()
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater)
        return binding.root
    }
    // функция, которая вызывается при создании нового экземпляра ResultFragment.
    // В этой функции создается и возвращается новый экземпляр FragmentResultBinding.

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.result.text = args.number.toString() + "/3"

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_quizFragment)
        }
    }
    // функция, которая вызывается после того, как ResultFragment был создан и прикреплен к активности.
    // В этой функции устанавливается текст на TextView с результатом и  кнопкой, при нажатии которой перенаправляет пользователя обратно на QuizFragment.

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    //этой функцией освобождаем ресурсы.
}