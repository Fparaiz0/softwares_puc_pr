#FERNANDO GABRIEL DOS SANTOS FERREIRA
#VICTOR HUGO GUEDES PIROZZI
#FELIPE PARAIZO DE OLIVEIRA
import dht
import machine
import time
import network
import urequests

#Configuração da rede(ou internet local)
ssid = "Nome do Wi-fi"
password = "Senha do Wi-fi"

#Conectando ao wifi local
wifi = network.WLAN(network.STA_IF)
wifi.active(True)
wifi.connect(ssid, password)

#tentativa de conexão
print("Conectando-se no WIFI..", end="")
while not wifi.isconnected():
    time.sleep(1)
    print(".", end="")
print("\nWiFi Conectado:", wifi.ifconfig())

#dht11 conectado no pino d4
d = dht.DHT11(machine.Pin(4))

#rele conectado no pino d5
rele = machine.Pin(5, machine.Pin.OUT)

# configuração para ThingSpeak
api_key = "Chave da API"
url = "https://api.thingspeak.com/update"


while True:
    try:
        d.measure()
        temp = d.temperature()
        umid = d.humidity()

     #condiçeõs para o envio de dados
        if temp > 31 or umid > 70:
            rele.value(1)
            status_rele = 1
            print("Relé Ligado")
        else:
            rele.value(0)
            status_rele = 0
            print("Relé Desligado")

        print("Temperatura: {}°C  Umidade: {}%".format(temp, umid))
    
      # try para envio de dads para ThingSpeak
        try:
            response = urequests.get(
                url +
                "?api_key=" + api_key +
                "&field1=" + str(temp) +
                "&field2=" + str(umid) +
                "&field3=" + str(status_rele)
            )
            print("Enviado para ThingSpeak:", response.text)
            response.close()
        except Exception as e:
            print("Erro ao enviar para ThingSpeak:", e)

    except Exception as e:
        print("Erro ao ler o sensor:", e)

    time.sleep(16) # intervalo de tempo que os dados são enviados