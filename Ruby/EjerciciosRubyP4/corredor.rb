# frozen_string_literal: true

require_relative './deportista.rb'

module Herencia
  class Corredor < Deportista
    def deporte
      result = "Estoy corriendo"
    end

    def to_s
      result = super
      result += " y soy corredor"
    end
  end
end

