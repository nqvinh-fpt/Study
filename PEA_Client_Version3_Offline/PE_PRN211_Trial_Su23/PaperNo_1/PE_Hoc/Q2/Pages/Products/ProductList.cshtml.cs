using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Q2.Models;

namespace Q2.Pages.Products
{
    public class ProductListModel : PageModel
    {
        private readonly LuyenOnThiDBContext context;

        public ProductListModel()
        {
            context = new LuyenOnThiDBContext();
        }
        public List<Product> products = new List<Product>();
        public void OnGet()
        {
            products = context.Products.ToList();
        }
    }
}
