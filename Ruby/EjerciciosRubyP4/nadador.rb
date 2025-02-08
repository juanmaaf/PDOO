# frozen_string_literal: true

require_relative './deportista.rb'

module Herencia
  class Nadador < Deportista
    def deporte
      result = "Estoy nadando"
    end

    def to_s
      result = super
      result += " y soy nadador"
    end
  end
end

