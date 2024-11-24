package com.jeffhb60.ecomshoppingcart.bootstrap;

import com.jeffhb60.ecomshoppingcart.model.Category;
import com.jeffhb60.ecomshoppingcart.model.Product;
import com.jeffhb60.ecomshoppingcart.repositories.CategoryRepository;
import com.jeffhb60.ecomshoppingcart.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@AllArgsConstructor
public class BootStrapData implements CommandLineRunner {

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Category> categories = null;
        if (categoryRepository.count() == 0) {

            categories = List.of(
                    new Category("Electronics"),
                    new Category("Clothing"),
                    new Category("Home Decor"),
                    new Category("Toys"),
                    new Category("Books"),
                    new Category("Shoes"),
                    new Category("Beauty Products"),
                    new Category("Sports Equipment"),
                    new Category("Kitchen Appliances"),
                    new Category("Outdoor Gear"),
                    new Category("Pet Supplies"),
                    new Category("Health and Wellness"),
                    new Category("Stationery"),
                    new Category("Gaming"),
                    new Category("Automotive"),
                    new Category("Jewelry"),
                    new Category("Art Supplies"),
                    new Category("Baby Products"),
                    new Category("Musical Instruments"),
                    new Category("Furniture"),
                    new Category("Groceries"),
                    new Category("Office Supplies"),
                    new Category("Seasonal Items"),
                    new Category("Bags and Accessories"),
                    new Category("Craft Supplies"),
                    new Category("Garden Supplies"),
                    new Category("Lighting"),
                    new Category("Travel Essentials"),
                    new Category("Fitness Gear"),
                    new Category("Electronics Accessories"),
                    new Category("Luxury Items"),
                    new Category("Cleaning Supplies"),
                    new Category("DIY Tools"),
                    new Category("Wine and Spirits"),
                    new Category("Gourmet Foods")
            );
            categoryRepository.saveAll(categories);
        }
        List<Category> allCategories = categoryRepository.findAll();
        if (allCategories.isEmpty()) {
            System.err.println("Categories could not be initialized.");
            return;
        }

        assert categories != null;
        Category electronics = categories.stream().filter(c -> c.getCategoryName().equals("Electronics")).findFirst().orElse(null);
        Category clothing = categories.stream().filter(c -> c.getCategoryName().equals("Clothing")).findFirst().orElse(null);
        Category homeDecor = categories.stream().filter(c -> c.getCategoryName().equals("Home Decor")).findFirst().orElse(null);
        Category toys = categories.stream().filter(c -> c.getCategoryName().equals("Toys")).findFirst().orElse(null);
        Category books = categories.stream().filter(c -> c.getCategoryName().equals("Books")).findFirst().orElse(null);
        Category shoes = categories.stream().filter(c -> c.getCategoryName().equals("Shoes")).findFirst().orElse(null);
        Category beautyProducts = categories.stream().filter(c -> c.getCategoryName().equals("Beauty Products")).findFirst().orElse(null);
        Category sportsEquipment = categories.stream().filter(c -> c.getCategoryName().equals("Sports Equipment")).findFirst().orElse(null);
        Category kitchenAppliances = categories.stream().filter(c -> c.getCategoryName().equals("Kitchen Appliances")).findFirst().orElse(null);
        Category outdoorGear = categories.stream().filter(c -> c.getCategoryName().equals("Outdoor Gear")).findFirst().orElse(null);
        Category petSupplies = categories.stream().filter(c -> c.getCategoryName().equals("Pet Supplies")).findFirst().orElse(null);
        Category healthAndWellness = categories.stream().filter(c -> c.getCategoryName().equals("Health and Wellness")).findFirst().orElse(null);
        Category stationery = categories.stream().filter(c -> c.getCategoryName().equals("Stationery")).findFirst().orElse(null);
        Category gaming = categories.stream().filter(c -> c.getCategoryName().equals("Gaming")).findFirst().orElse(null);
        Category automotive = categories.stream().filter(c -> c.getCategoryName().equals("Automotive")).findFirst().orElse(null);
        Category jewelry = categories.stream().filter(c -> c.getCategoryName().equals("Jewelry")).findFirst().orElse(null);
        Category artSupplies = categories.stream().filter(c -> c.getCategoryName().equals("Art Supplies")).findFirst().orElse(null);
        Category babyProducts = categories.stream().filter(c -> c.getCategoryName().equals("Baby Products")).findFirst().orElse(null);
        Category musicalInstruments = categories.stream().filter(c -> c.getCategoryName().equals("Musical Instruments")).findFirst().orElse(null);
        Category furniture = categories.stream().filter(c -> c.getCategoryName().equals("Furniture")).findFirst().orElse(null);
        Category groceries = categories.stream().filter(c -> c.getCategoryName().equals("Groceries")).findFirst().orElse(null);
        Category officeSupplies = categories.stream().filter(c -> c.getCategoryName().equals("Office Supplies")).findFirst().orElse(null);
        Category seasonalItems = categories.stream().filter(c -> c.getCategoryName().equals("Seasonal Items")).findFirst().orElse(null);
        Category bagsAndAccessories = categories.stream().filter(c -> c.getCategoryName().equals("Bags and Accessories")).findFirst().orElse(null);
        Category craftSupplies = categories.stream().filter(c -> c.getCategoryName().equals("Craft Supplies")).findFirst().orElse(null);
        Category gardenSupplies = categories.stream().filter(c -> c.getCategoryName().equals("Garden Supplies")).findFirst().orElse(null);
        Category lighting = categories.stream().filter(c -> c.getCategoryName().equals("Lighting")).findFirst().orElse(null);
        Category travelEssentials = categories.stream().filter(c -> c.getCategoryName().equals("Travel Essentials")).findFirst().orElse(null);
        Category fitnessGear = categories.stream().filter(c -> c.getCategoryName().equals("Fitness Gear")).findFirst().orElse(null);
        Category electronicsAccessories = categories.stream().filter(c -> c.getCategoryName().equals("Electronics Accessories")).findFirst().orElse(null);
        Category luxuryItems = categories.stream().filter(c -> c.getCategoryName().equals("Luxury Items")).findFirst().orElse(null);
        Category cleaningSupplies = categories.stream().filter(c -> c.getCategoryName().equals("Cleaning Supplies")).findFirst().orElse(null);
        Category diyTools = categories.stream().filter(c -> c.getCategoryName().equals("DIY Tools")).findFirst().orElse(null);
        Category wineAndSpirits = categories.stream().filter(c -> c.getCategoryName().equals("Wine and Spirits")).findFirst().orElse(null);
        Category gourmetFoods = categories.stream().filter(c -> c.getCategoryName().equals("Gourmet Foods")).findFirst().orElse(null);

        if (productRepository.count() == 0) {
            List<Product> products = List.of(
                    new Product(null, "Smartphone", "smartphone.jpg", "Latest smartphone with cutting-edge features.", 100, 699.99, 10, 629.99, electronics),
                    new Product(null, "Laptop", "laptop.jpg", "High-performance laptop for professionals.", 50, 1199.99, 15, 1019.99, electronics),
                    new Product(null, "Headphones", "headphones.jpg", "Noise-cancelling wireless headphones.", 80, 199.99, 20, 159.99, electronics),
                    new Product(null, "Television", "television.jpg", "4K Ultra HD Smart TV.", 30, 899.99, 10, 809.99, electronics),
                    new Product(null, "Gaming Console", "gamingconsole.jpg", "Next-gen gaming console.", 40, 499.99, 5, 474.99, gaming),
                    new Product(null, "Jeans", "jeans.jpg", "Stylish denim jeans for casual wear.", 150, 49.99, 10, 44.99, clothing),
                    new Product(null, "T-shirt", "tshirt.jpg", "Comfortable cotton T-shirt in various colors.", 200, 19.99, 5, 18.99, clothing),
                    new Product(null, "Sneakers", "sneakers.jpg", "Lightweight running sneakers.", 100, 89.99, 15, 76.49, shoes),
                    new Product(null, "Dress", "dress.jpg", "Elegant evening dress.", 60, 129.99, 20, 103.99, clothing),
                    new Product(null, "Wristwatch", "wristwatch.jpg", "Stylish analog wristwatch.", 80, 249.99, 25, 187.49, jewelry),
                    new Product(null, "Necklace", "necklace.jpg", "Beautiful gold-plated necklace.", 50, 299.99, 30, 209.99, jewelry),
                    new Product(null, "Cookware Set", "cookwareset.jpg", "Premium stainless steel cookware set.", 40, 199.99, 10, 179.99, kitchenAppliances),
                    new Product(null, "Blender", "blender.jpg", "High-speed blender for smoothies.", 70, 59.99, 15, 50.99, kitchenAppliances),
                    new Product(null, "Air Fryer", "airfryer.jpg", "Oil-free air fryer for healthy cooking.", 50, 119.99, 20, 95.99, kitchenAppliances),
                    new Product(null, "Book - Science Fiction", "book-sciencefiction.jpg", "Bestselling science fiction novel.", 120, 14.99, 10, 13.49, books),
                    new Product(null, "Book - Mystery", "book-mystery.jpg", "A thrilling mystery novel.", 80, 19.99, 5, 18.99, books),
                    new Product(null, "Soccer Ball", "soccerball.jpg", "Professional-grade soccer ball.", 100, 29.99, 10, 26.99, sportsEquipment),
                    new Product(null, "Basketball", "basketball.jpg", "Durable outdoor basketball.", 120, 39.99, 15, 33.99, sportsEquipment),
                    new Product(null, "Yoga Mat", "yogamat.jpg", "Non-slip yoga mat for fitness.", 150, 25.99, 20, 20.79, fitnessGear),
                    new Product(null, "Dumbbells", "dumbbells.jpg", "Adjustable dumbbell set.", 60, 49.99, 15, 42.49, fitnessGear),
                    new Product(null, "Wall Art", "wallart.jpg", "Abstract canvas wall art.", 30, 89.99, 20, 71.99, homeDecor),
                    new Product(null, "Floor Lamp", "floorlamp.jpg", "Modern LED floor lamp.", 40, 79.99, 10, 71.99, lighting),
                    new Product(null, "Baby Stroller", "babystroller.jpg", "Lightweight baby stroller.", 25, 159.99, 15, 135.99, babyProducts),
                    new Product(null, "Baby Monitor", "babymonitor.jpg", "Digital baby monitor with camera.", 50, 99.99, 20, 79.99, babyProducts),
                    new Product(null, "Guitar", "guitar.jpg", "Acoustic guitar for beginners.", 30, 149.99, 10, 134.99, musicalInstruments),
                    new Product(null, "Piano Keyboard", "pianokeyboard.jpg", "61-key electronic keyboard.", 20, 199.99, 15, 169.99, musicalInstruments),
                    new Product(null, "Sketchbook", "sketchbook.jpg", "Premium sketchbook for artists.", 100, 14.99, 5, 14.24, artSupplies),
                    new Product(null, "Paint Set", "paintset.jpg", "Acrylic paint set for art projects.", 80, 29.99, 10, 26.99, artSupplies),
                    new Product(null, "Car Tire", "cartire.jpg", "All-season car tire.", 50, 99.99, 10, 89.99, automotive),
                    new Product(null, "Car Wax", "carwax.jpg", "Premium car wax for a shiny finish.", 150, 19.99, 15, 16.99, automotive),
                    new Product(null, "Tent", "tent.jpg", "Waterproof camping tent for 4 people.", 30, 129.99, 20, 103.99, outdoorGear),
                    new Product(null, "Sleeping Bag", "sleepingbag.jpg", "Comfortable sleeping bag for camping.", 50, 59.99, 15, 50.99, outdoorGear),
                    new Product(null, "Dog Food", "dogfood.jpg", "Nutritious dog food.", 200, 49.99, 10, 44.99, petSupplies),
                    new Product(null, "Cat Toy", "cattoy.jpg", "Interactive toy for cats.", 150, 14.99, 5, 14.24, petSupplies),
                    new Product(null, "Water Bottle", "waterbottle.jpg", "Stainless steel insulated water bottle.", 100, 24.99, 10, 22.49, travelEssentials),
                    new Product(null, "Backpack", "backpack.jpg", "Durable hiking backpack.", 80, 59.99, 15, 50.99, travelEssentials),
                    new Product(null, "Wine Glasses", "wineglasses.jpg", "Set of crystal wine glasses.", 30, 39.99, 20, 31.99, wineAndSpirits),
                    new Product(null, "Cheese Platter", "cheeseplatter.jpg", "Gourmet cheese platter for events.", 20, 49.99, 15, 42.49, gourmetFoods),
                    new Product(null, "Robot Vacuum", "robotvacuum.jpg", "Smart robot vacuum cleaner for effortless cleaning.", 40, 299.99, 25, 224.99, cleaningSupplies),
                    new Product(null, "Toolbox", "toolbox.jpg", "Complete DIY toolbox with essential tools.", 60, 79.99, 10, 71.99, diyTools),
                    new Product(null, "Cordless Drill", "cordlessdrill.jpg", "High-performance cordless drill.", 50, 119.99, 20, 95.99, diyTools),
                    new Product(null, "Luxury Watch", "luxurywatch.jpg", "Premium Swiss luxury watch.", 15, 4999.99, 30, 3499.99, luxuryItems),
                    new Product(null, "Perfume", "perfume.jpg", "Exclusive designer perfume.", 60, 199.99, 20, 159.99, beautyProducts),
                    new Product(null, "Lipstick Set", "lipstickset.jpg", "Matte lipstick set in vibrant shades.", 100, 49.99, 15, 42.49, beautyProducts),
                    new Product(null, "Exercise Bike", "exercisebike.jpg", "Indoor exercise bike for cardio workouts.", 30, 499.99, 25, 374.99, fitnessGear),
                    new Product(null, "Pull-Up Bar", "pullupbar.jpg", "Wall-mounted pull-up bar.", 80, 59.99, 10, 53.99, fitnessGear),
                    new Product(null, "Garden Shovel", "gardenshovel.jpg", "Heavy-duty garden shovel.", 100, 29.99, 15, 25.49, gardenSupplies),
                    new Product(null, "Lawn Mower", "lawnmower.jpg", "Electric lawn mower for large yards.", 20, 399.99, 20, 319.99, gardenSupplies),
                    new Product(null, "Desk Lamp", "desklamp.jpg", "LED desk lamp with adjustable brightness.", 120, 39.99, 10, 35.99, lighting),
                    new Product(null, "Chandelier", "chandelier.jpg", "Elegant crystal chandelier.", 10, 599.99, 25, 449.99, lighting),
                    new Product(null, "Leather Bag", "leatherbag.jpg", "Premium leather travel bag.", 40, 199.99, 15, 169.99, bagsAndAccessories),
                    new Product(null, "Wallet", "wallet.jpg", "Compact leather wallet.", 150, 49.99, 10, 44.99, bagsAndAccessories),
                    new Product(null, "Notebook", "notebook.jpg", "Spiral-bound notebook for daily use.", 200, 5.99, 10, 5.39, stationery),
                    new Product(null, "Planner", "planner.jpg", "2024 daily planner.", 100, 14.99, 15, 12.74, stationery),
                    new Product(null, "Craft Glue", "craftglue.jpg", "Strong adhesive craft glue.", 120, 3.99, 5, 3.79, craftSupplies),
                    new Product(null, "Sewing Kit", "sewingkit.jpg", "Portable sewing kit for crafts.", 60, 19.99, 10, 17.99, craftSupplies),
                    new Product(null, "Wine Bottle", "winebottle.jpg", "Premium red wine from Italy.", 50, 29.99, 20, 23.99, wineAndSpirits),
                    new Product(null, "Cheeseboard", "cheeseboard.jpg", "Rustic wooden cheeseboard.", 40, 39.99, 10, 35.99, gourmetFoods),
                    new Product(null, "Espresso Machine", "espressomachine.jpg", "Automatic espresso machine for coffee lovers.", 30, 699.99, 20, 559.99, kitchenAppliances),
                    new Product(null, "Microwave Oven", "microwaveoven.jpg", "Compact microwave oven with multiple settings.", 50, 199.99, 15, 169.99, kitchenAppliances),
                    new Product(null, "Basketball Hoop", "basketballhoop.jpg", "Adjustable outdoor basketball hoop.", 20, 349.99, 25, 262.49, sportsEquipment),
                    new Product(null, "Tennis Racket", "tennisracket.jpg", "Lightweight professional tennis racket.", 60, 149.99, 15, 127.49, sportsEquipment),
                    new Product(null, "Playhouse", "playhouse.jpg", "Outdoor playhouse for kids.", 15, 399.99, 20, 319.99, toys),
                    new Product(null, "Action Figures", "actionfigures.jpg", "Set of collectible action figures.", 100, 59.99, 10, 53.99, toys),
                    new Product(null, "Electric Kettle", "electrickettle.jpg", "Stainless steel electric kettle.", 80, 49.99, 15, 42.49, kitchenAppliances),
                    new Product(null, "Blender", "blender.jpg", "Compact blender for smoothies.", 120, 69.99, 10, 62.99, kitchenAppliances),
                    new Product(null, "Dog Bed", "dogbed.jpg", "Comfortable dog bed for all sizes.", 70, 79.99, 20, 63.99, petSupplies),
                    new Product(null, "Cat Litter Box", "catlitterbox.jpg", "Odor-free litter box for cats.", 90, 49.99, 15, 42.49, petSupplies),
                    new Product(null, "Bookshelf", "bookshelf.jpg", "Compact wooden bookshelf.", 40, 99.99, 15, 84.99, furniture),
                    new Product(null, "Office Chair", "officechair.jpg", "Ergonomic office chair for comfort.", 30, 299.99, 20, 239.99, furniture),
                    new Product(null, "Notebook", "notebook.jpg", "Portable notebook for jotting down ideas.", 200, 4.99, 5, 4.74, stationery),
                    new Product(null, "Candle Set", "candleset.jpg", "Aromatic candle set for relaxation.", 80, 19.99, 10, 17.99, seasonalItems),
                    new Product(null, "Holiday Lights", "holidaylights.jpg", "Colorful LED holiday lights.", 100, 29.99, 15, 25.49, seasonalItems),
                    new Product(null, "Bluetooth Speaker", "bluetoothspeaker.jpg", "Portable Bluetooth speaker with powerful bass.", 70, 99.99, 10, 89.99, electronicsAccessories),
                    new Product(null, "Power Bank", "powerbank.jpg", "High-capacity portable power bank.", 120, 49.99, 15, 42.49, electronicsAccessories),
                    new Product(null, "Leather Gloves", "leathergloves.jpg", "Premium leather gloves for winter.", 60, 39.99, 10, 35.99, clothing),
                    new Product(null, "Scarf", "scarf.jpg", "Soft woolen scarf for cold weather.", 100, 19.99, 5, 18.99, clothing)
            );
            productRepository.saveAll(products);
        }

    }
}


