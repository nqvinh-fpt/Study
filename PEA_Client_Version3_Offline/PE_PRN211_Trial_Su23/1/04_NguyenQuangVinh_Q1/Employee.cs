﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace _04_NguyenQuangVinh_Q1
{
    public class Employee
    {
        public int Id { get; set; }
        public string Name { get; set; } = null!;
        public string Dob { get; set; }
        public string? Sex { get; set; }
        public string? Position { get; set; }
        public int Department { get; set; }
        public string? DepartmentName { get; set; }
    }
}
