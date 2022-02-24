package com.example.gestiunechirii;

import android.os.Parcel;
import android.os.Parcelable;

public class Houses {
        Integer id;
        private String nameHouse;
        private String location;


        public Houses(Integer id, String nameHouse, String location) {
                this.id = id;
                this.nameHouse = nameHouse;
                this.location = location;
        }

        public Houses(String nameHouse, String location) {
                this.nameHouse = nameHouse;
                this.location = location;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getNameHouse() {
                return nameHouse;
        }

        public void setNameHouse(String nameHouse) {
                this.nameHouse = nameHouse;
        }

        public String getLocation() {
                return location;
        }

        public void setLocation(String location) {
                this.location = location;
        }

        @Override
        public String toString() {
                return "Houses{" +
                        "id=" + id +
                        ", nameHouse='" + nameHouse + '\'' +
                        ", location='" + location + '\'' +
                        '}';
        }
}
