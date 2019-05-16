package week2.Collections.Map.LinkedHashMap;

import java.io.Serializable;


public class WebSites implements Comparable<week2.Collections.Map.LinkedHashMap.WebSites>,Cloneable, Serializable {
        String ip;
        String domainName;
        int users;

        public WebSites(String ip, String domainName, int users) {
            this.ip = ip;
            this.domainName = domainName;
            this.users = users;
        }

        @Override
        public int compareTo(week2.Collections.Map.LinkedHashMap.WebSites o) {
            if(this.users>o.users)
                return 1;
            if(this.users<o.users)
                return -1;
            else
                return 0;
        }

        @Override
        public String toString() {
            return "WebSites{" +
                    "ip='" + ip + '\'' +
                    ", domainName='" + domainName + '\'' +
                    ", users=" + users +
                    '}';
        }




    }


