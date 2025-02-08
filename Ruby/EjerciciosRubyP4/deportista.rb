# frozen_string_literal: true

require_relative './persona.rb'

module Herencia
  class Deportista < Persona
    attr_reader :horas_entrenamiento

    def initialize(nombre, n)
      super(nombre)
      @horas_entrenamiento = n
    end

    def competicion_deportiva
      result = "Voy a una competicion deportiva y entreno #{@horas_entrenamiento} horas"
    end
  end
end

