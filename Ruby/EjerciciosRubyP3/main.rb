require_relative 'vista_laberinto.rb'
require_relative 'vista2_laberinto.rb'
require_relative 'controlador_laberinto/controlador.rb'
require_relative 'modelo_laberinto/laberinto.rb'

modelo = Modelo_laberinto::Laberinto.new
controlador = Controlador_laberinto::Controlador.new(modelo)
vista = Vista_laberinto.new(controlador)
#vista2 = Vista2_laberinto.new(controlador, modelo)

vista.menu_usuario
#vista2.menu_usuario
