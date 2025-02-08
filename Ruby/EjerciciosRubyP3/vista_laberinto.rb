class Vista_laberinto
  def initialize(controlador)
    @controlador = controlador
  end

  def menu_usuario
    estado = @controlador.estado
    if estado == Controlador_laberinto::Estado_juego::EN_ENTRADA_LABERINTO
      puts "Introduza el número de vidas con el que quiere empezar la partida (entre 1 y 10): "
      vidas_s = gets.chomp
      while vidas_s.to_i < 1 || vidas_s.to_i > 10
        puts "Intoduzca el número de vidas (entre 1 y 10): "
        vidas_s = gets.chomp
      end
      @controlador.entrar(vidas_s.to_i)
    else if estado == Controlador_laberinto::Estado_juego::DENTRO_VIVO
           informe_dentro(@controlador.habitacion_usuario, @controlador.vidas)
           puts "Pulse enter para avanzar: "
           tecla = gets.chomp
           puts "Dirección a la que pretende dirigirse: " +Modelo_laberinto::Lista_direcciones[@controlador.intentar_avanzar]
         else
           informe_final(@controlador.vidas)
           if estado == Controlador_laberinto::Estado_juego::DENTRO_MUERTO
             puts "F. Ha perdido"
           else
             puts "De Locos. Ha ganado"
           end
           exit(0)
         end
    end
    menu_usuario
  end

  def informe_dentro(habitacion, vidas)
    puts "Situación actual->  Habitación número: " +habitacion.num_habitacion.to_s + "  Vídas restantes: " +vidas.to_s
  end

  def informe_final(vidas)
    puts "Fin del Juego. Vidas finales: " +vidas.to_s
  end
end
