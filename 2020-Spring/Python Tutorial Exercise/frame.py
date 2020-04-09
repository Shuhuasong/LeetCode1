from tkinter import *

window = Tk()

#Frame
fTop = Frame(window)
fTop.pack()

fBottom = Frame(window)
fBottom.pack(side=BOTTOM)

#Label
label1 = Label(fTop, text="Label")
label1.pack(side=LEFT)
label2 = Label(fTop, text="Label2")
label2.pack(side=RIGHT)
label3 = Label(fBottom, text="Label3")
label3.pack()

def handleClick():
    print("Button Clicked")
button1 = Button(window, bd=20, bg='#007700', fg="Green", text="Click Me",
                 padx=25, pady=40, command=handleClick)
button1.place(x=25, y=25)



#get the input from user

def printInput():
    print(input.get())
input = StringVar()#An object
input.trace("w", lambda name, index, mode : printInput())# track the user's input, call back: lamda Expression
entry = Entry(window, fg="Black", bd = 5, bg="Gray", textvariable = input)
entry.pack()

window.mainloop()
