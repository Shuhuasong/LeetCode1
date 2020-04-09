from tkinter import *

window =  Tk()
window.title("ToDo-List")

content = Listbox(window, font = "Ariel 24 bold")

task = StringVar()#get the value fron user input
entry = Entry(window, textvariable=task, font="Ariel 24")

add = Button(window, text="ADD", font = "Ariel 20",
             command= lambda content=content, task=task: content.insert(END, task.get()))

delete = Button(window, text="DELETE", font ="Ariel 20",
             command=lambda content=content : content.delete(ANCHOR))#ANCHOR: find the one we check

content.grid(row=0, column = 0, columnspan=2, padx=5, pady=10)
entry.grid(row=1, column=0, columnspan=2, padx=5, pady=10)
add.grid(row=2,column = 0,  padx=5, pady=10 )
delete.grid(row=2,column = 1,  padx=5, pady=10 )

window.mainloop()


