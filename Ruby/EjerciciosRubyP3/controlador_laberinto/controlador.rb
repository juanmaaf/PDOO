require_relative "estado_juego.rb"
require_relative "operacion.rb"

module Controlador_laberinto

class Controlador
  def initialize (modelo)
    @vidas = 0
    @habitacion_usuario = nil
    @modelo = modelo
    @estado = Estado_juego::EN_ENTRADA_LABERINTO
  end

  attr_reader :modelo, :vidas, :habitacion_usuario, :estado
  def estado
    @estado
  end

  def entrar(vidas)
    @vidas = vidas
    @habitacion_usuario = @modelo.puerta_entrada.habitacion_al_otro_lado(nil)
    pared = Elemento_separador.nueva_pared(habitacion_usuario, nil)
    @habitacion_usuario.set_lado(Modelo_laberinto::Direccion::SUR, pared)
    @estado = Estado_juego::DENTRO_VIVO
  end

  def intentar_avanzar
    direccion = rand(4)
    lado = @habitacion_usuario.get_lado(direccion)
    if @habitacion_usuario.pasar(direccion)
      @habitacion_usuario = lado.habitacion_al_otro_lado(@habitacion_usuario)
    else
      @vidas -= 1
      if vidas <= 0
        @estado = Estado_juego::DENTRO_MUERTO
      end
    end
    if @habitacion_usuario == nil
      @estado = Estado_juego::EN_SALIDA_LABERINTO
    end
    direccion
  end

  def vidas
    @vidas
  end

  def habitacion_usuario
    @habitacion_usuario
  end
end

end