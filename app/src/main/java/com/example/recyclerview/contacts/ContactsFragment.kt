package com.example.recyclerview.contacts

import android.graphics.PostProcessor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import com.example.recyclerview.databinding.FragmentContactsBinding


class ContactsFragment : Fragment() {

    private var _binding: FragmentContactsBinding? = null
    private val binding
        get() = _binding!!

    private var contacts = contactList()

    private val contactsAdapter = ContactsAdapter(
        contacts,
        onClickEditBtn = { position -> onClickEditBtn(position) },
        onClickCheckbox = { position -> onClickCheckbox(position) }
    )
    private var editPosition = contacts.last().firstName.filter { it.isDigit() }.toInt()
    var deletedContacts = mutableListOf<Contact>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerview.adapter = contactsAdapter

        binding.btnAdd.setOnClickListener {
            updateList(contacts.plus(addContact()))
        }

        binding.btnDelete.setOnClickListener {
            updateList(contacts.minus(deletedContacts))
            deletedContacts.clear()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun contactList(): List<Contact> {
        val contacts = mutableListOf<Contact>()
        for (i in 1..100) {
            contacts.add(Contact(i, "Имя$i", "Фамилия$i", "8-800-$i$i"))
        }
        return contacts
    }

    private fun addContact(): Contact {
        val nextNumber = contacts.last().firstName.filter { it.isDigit() }.toInt() + 1
        return Contact(
            nextNumber,
            "Имя$nextNumber",
            "Фамилия$nextNumber",
            "8-800-$nextNumber$nextNumber$nextNumber"
        )
    }

    private fun onClickEditBtn(position: Int) {
        val newContactList = contacts.toMutableList()
        editPosition++
        newContactList[position] = Contact(
            newContactList[position].id,
            "Имя$editPosition",
            "Фамилия$editPosition",
            "8-800-$editPosition$editPosition"
        )
        updateList(newContactList)
    }

    private fun onClickCheckbox(position: Int){
        deletedContacts.add(contacts[position])
    }

    private fun updateList(newList: List<Contact>) {
        val result = DiffUtil.calculateDiff(
            ContactsDiffUtilCallback(
                contacts,
                newList
            )
        )
        contactsAdapter.contacts = newList
        result.dispatchUpdatesTo(contactsAdapter)
        contacts = newList
    }

    companion object {
        @JvmStatic
        fun newInstance() = ContactsFragment()
    }

}