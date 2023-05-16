public class Tv {
     String color;
     boolean power;
     int channel;
     int volume;
     void power() { power = !power;}
     void channelUp() {
          if (channel>999) {
               channel=1;
               return;
          }
          channel++;
     }
     void channelDown() {
          if(channel<1) {
               channel=999;
               return;
          }
          channel--;
     }
     void volumeUp() {
          volume++;
     }
     void volumeDown() {
          volume--;
     }
}