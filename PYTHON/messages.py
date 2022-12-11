import pyautogui as pt
import time

limit = input("Cantidad de mensajes:")
message = input("Mensaje:")
i=0

time.sleep(3)

while i < int(limit):
    pt.typewrite(message)
    pt.press("enter")
    i +- 1