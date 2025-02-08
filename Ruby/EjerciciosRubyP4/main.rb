# frozen_string_literal: true

require_relative './nadador.rb'
require_relative './corredor.rb'

p1 = Herencia::Persona.new("Juanma")
d1 = Herencia::Deportista.new("Antonio", 10)
n1 = Herencia::Nadador.new("Pablo", 10)
c1 = Herencia::Corredor.new("Jose", 0)

puts p1.andar()
puts d1.andar()
puts n1.andar()
puts c1.andar()
puts ""

puts p1.to_s()
puts d1.to_s()
puts n1.to_s()
puts c1.to_s()
puts ""

puts p1.nombre
puts d1.nombre
puts n1.nombre
puts c1.nombre
puts ""

puts d1.horas_entrenamiento
puts n1.horas_entrenamiento
puts c1.horas_entrenamiento
puts ""

puts d1.competicion_deportiva()
puts n1.competicion_deportiva()
puts c1.competicion_deportiva()
puts ""