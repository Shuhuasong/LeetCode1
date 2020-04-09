from tkinter import *
from tkinter import ttk
window = Tk()

#CheckBox
def callback():
    print(checkVar.get())
checkVar = IntVar() #or StringVar()
checkButton = Checkbutton(window, text = "Option 1",
                          width=50, height=10,  variable = checkVar,
                          command = callback, onvalue = 100, offvalue = -1)
checkButton.pack()

#ComboBox
def callback(event):
    print(event.widge.get())
comValues = ("A", "B", "C")#list the possible value
comBox =  ttk.Combobox(window, value=comValues)
comBox.set("B") #set the default value
comBox.bind("<<ComboboxSelected>>", callback)#bind the click event, The combobox widgets generates a <<ComboboxSelected>> virtual event when the user selects an element from the list of values.
comBox.pack()

#Show an Image on Window
img = PhotoImage(file="water.png ")
temp = Label(window, image=img)
temp.pack()
window.mainloop()