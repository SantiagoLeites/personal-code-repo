import pgzrun
import random
import pygame

 


# screen = pygame.display.set_mode((800, 600)) 

# pygame.display.set_caption('Button Demo')


# start_img = pygame.image.load('start_btn.png').convert_alpha()
# exit_img = pygame.image.load('exit_btn.png').convert_alpha()


# class Button():
#    def __init__(self, x, y, image):
#        self.image = image
#        self.rect = self.image.get_rect()
#        self.rect.topleft = (x, y)
#
#    def draw(self):
        
#        screen.blit(self.image, (self.rect.x, self.rect.y))


#start_button = Button(100, 200, start_img)
#exit_button = Button(450, 200, exit_img)


run = True
while run:

    #screen.fill((202, 228, 251))

    #start_button.draw()
    #exit_button.draw()

    TITLE = "Arkanoid clone"
    WIDTH = 800
    HEIGHT = 500

    paddle = Actor("paddlered.png")
    paddle.x = 120
    paddle.y = 420

    ball = Actor("ballgrey.png")
    ball.x = 100
    ball.y = 300

    ball_x_speed = -2
    ball_y_speed = -2

    bars_list = []

    def draw():
        screen.blit("background.png", (0,0))
        paddle.draw()
        ball.draw()
        for bar in bars_list:
            bar.draw()


    def place_bars(x,y,image):
        bar_x = x
        bar_y = y
        for i in range(9):
            bar = Actor(image)
            bar.x = bar_x
            bar.y = bar_y
            bar_x += 70
            bars_list.append(bar)

    def update():
        global ball_x_speed, ball_y_speed
        if keyboard.left:
            paddle.x = paddle.x - 5
        if keyboard.right:
            paddle.x = paddle.x + 5

        update_ball()
        for bar in bars_list:
            if ball.colliderect(bar):
                bars_list.remove(bar)
                ball_y_speed *= -1


        if paddle.colliderect(ball):
            ball_y_speed *= -1
            # randomly move ball left or right on hit
            rand = random.randint(0,1)
            if rand:
                ball_x_speed *= -1

    def update_ball():
        global ball_x_speed, ball_y_speed
        ball.x -= ball_x_speed
        ball.y -= ball_y_speed
        if (ball.x >= WIDTH) or (ball.x <=0):
            ball_x_speed *= -1
        if (ball.y >= HEIGHT) or (ball.y <=0):
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    run = False

                pygame.display.update()        
            pygame.quit()
            pass



    coloured_box_list = ["element_blue_rectangle_glossy.png", "element_green_rectangle_glossy.png","element_red_rectangle_glossy.png","element_yellow_rectangle_glossy.png"]
    x = 120
    y = 100
    for coloured_box in coloured_box_list:
        place_bars(x, y, coloured_box)
        y += 50


    pgzrun.go()
    break    