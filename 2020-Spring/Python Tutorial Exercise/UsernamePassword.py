from tkinter import *

window = Tk()

nameLabel = Label(window, text = "Username")
passwordLabel = Label(window, text = "Password")

userE = Entry(window)
passE = Entry(window)

nameLabel.grid(row=0,stick=E) #set label align with left
passwordLabel.grid(row=1, stick=E)
userE.grid(row=0, column=1)
passE.grid(row=1, column = 1)

window.mainloop()


