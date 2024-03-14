package com.example.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.quiz.databinding.FragmentQuizBinding


class QuizFragment : Fragment() {

    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizBinding.inflate(inflater)
        return binding.root
    }
    // onCreateView создает и возвращает вид фрагмента.

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val number = getAnswersByUser()
            val action = QuizFragmentDirections.actionQuizFragmentToResultFragment(number)
            findNavController().navigate(action)

        }
    }
    //    В функции onViewCreated устанавливается кнопка с id button. Когда пользователь нажимает на эту кнопку, вызывается функция getAnswersByUser.
//    Затем создается объект action, который содержит число правильных ответов в качестве аргумента.
//    затем вызывает функцию navigate, которая перенаправляет пользователя на ResultFragment.

    private fun getAnswersByUser(): Int {
        var correctAnswersCount = 0

        if (binding.question1.checkedRadioButtonId == binding.answer12.id) correctAnswersCount++
        if (binding.question2.checkedRadioButtonId == binding.answer21.id) correctAnswersCount++
        if (binding.question3.checkedRadioButtonId == binding.answer31.id) correctAnswersCount++

        return correctAnswersCount
    }
    // getAnswersByUser проверяется, какой из радио-кнопок был выбран в каждом вопросе. В конце функция возвращает значение счетчика правильных ответов.
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    // В функции onDestroy устанавливается значение _binding в null, что позволяет освободить ресурсы, связанные с этим фрагментом.
}