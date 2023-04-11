import sys
from PyQt5.QtWidgets import QApplication, QMainWindow, QWidget, QVBoxLayout, QLabel, QFormLayout, QLineEdit, QTextEdit, QLCDNumber, QAction, QFileDialog, QCalendarWidget, QMessageBox
from PyQt5.QtCore import QTimer, QTime, Qt, QDateTime
from PyQt5.QtGui import QPalette, QColor
from PyQt4.QtCore import QPixmap

class CalendarApp(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Calendario con Notas y Reloj")
        self.setGeometry(100, 100, 800, 300)

        # Cargar la imagen de fondo vaporwave
        background_image = QPixmap('C:\Users\Santiago\Pictures\deah.png')
        if not background_image.isNull():
            self.setFixedSize(background_image.width(), background_image.height())
            self.setPixmap(background_image)

        # Crear la ventana principal
        self.main_widget = QWidget(self)
        self.setCentralWidget(self.main_widget)

        # Crear los widgets
        self.clock = QLCDNumber(self)
        self.notes_edit = QTextEdit(self)
        self.notes_edit.setPlaceholderText("Escribe tus notas aquí")

        # Crear un temporizador para actualizar el reloj cada segundo
        self.timer = QTimer()
        self.timer.timeout.connect(self.update_time)
        self.timer.start(1000)

        # Crear el widget de calendario
        self.calendar = QCalendarWidget(self)

        # Crear los menús y acciones
        self.file_menu = self.menuBar().addMenu("File")
        self.open_action = QAction("Abrir", self)
        self.open_action.triggered.connect(self.open_notes)
        self.file_menu.addAction(self.open_action)

        self.save_action = QAction("Guardar", self)
        self.save_action.triggered.connect(self.save_notes)
        self.file_menu.addAction(self.save_action)

        # Crear el diseño de la ventana principal
        layout = QVBoxLayout(self.main_widget)

        # Configurar el fondo negro para el reloj
        pal = self.clock.palette()
        pal.setColor(QPalette.Background, QColor("black"))
        self.clock.setAutoFillBackground(True)
        self.clock.setPalette(pal)

        layout.addWidget(self.clock)
        layout.addWidget(self.notes_edit)
        layout.addWidget(self.calendar)

    def update_time(self):
        # Actualizar el tiempo en el reloj
        current_time = QTime.currentTime()
        self.clock.display(current_time.toString("hh:mm:ss"))

    def save_notes(self):
        # Guardar las notas en un archivo de texto junto con la fecha y hora actual
        file_path, _ = QFileDialog.getSaveFileName(self, 'Guardar Notas', '', 'Archivos de Texto (*.txt)')
        if file_path:
            with open(file_path, 'w') as file:
                current_datetime = QDateTime.currentDateTime()
                file.write(f'Fecha y hora: {current_datetime.toString()} \n\n')
                file.write(self.notes_edit.toPlainText())
                file.close()

    def open_notes(self):
        # Abrir un archivo de texto con las notas guardadas
        file_path, _ = QFileDialog.getOpenFileName(self, 'Abrir Notas', '', 'Archivos de Texto (*.txt)')
        if file_path:
            try:
                with open(file_path, 'r') as file:
                    notes = file.read()
                    self.notes_edit.setPlainText(notes)
                    file.close()
            except Exception as e:
                QMessageBox.warning(self, 'Error', f'No se pudo abrir el archivo: {str(e)}')

if __name__ == '__main__':
    app = QApplication(sys.argv)
    window = CalendarApp()
    window.show()
    sys.exit(app.exec_())
