import React, { useMemo, useState } from "react";

export default function FastFoodMenu() {
    const products = useMemo(
        () => [
            {
                id: "burger",
                title: "Burger",
                desc: "Juicy beef burger with cheese",
                price: 89,
            },
            {
                id: "fries",
                title: "Fries",
                desc: "Crispy golden french fries",
                price: 39,
            },
            {
                id: "soda",
                title: "Soda",
                desc: "Refreshing cold drink",
                price: 25,
            },
        ],
        []
    );


    const [theme, setTheme] = useState("dark");
    const [cart, setCart] = useState({});

    const addToOrder = (p) => {
        setCart((prev) => {
            const next = { ...prev };
            const item = next[p.id] ?? { qty: 0, product: p };
            item.qty += 1;
            next[p.id] = item;
            return next;
        });
    };

    const decrease = (id) => {
        setCart((prev) => {
            if (!prev[id]) return prev;
            const next = { ...prev };
            const qty = next[id].qty - 1;
            if (qty <= 0) delete next[id];
            else next[id] = { ...next[id], qty };
            return next;
        });
    };

    const increase = (id) => {
        setCart((prev) => {
            if (!prev[id]) return prev;
            const next = { ...prev };
            next[id] = { ...next[id], qty: next[id].qty + 1 };
            return next;
        });
    };

    const clearOrder = () => setCart({});

    const items = Object.values(cart);
    const total = items.reduce((sum, it) => sum + it.qty * it.product.price, 0);


    const isDark = theme === "dark";
    const pageClasses = isDark ? "bg-dark text-light" : "bg-light text-dark";
    const cardText = isDark ? "text-dark" : "text-dark";

    return (
        <div className={`${pageClasses} min-vh-100`}>
            <div className="container py-4">

                <div className="d-flex align-items-center justify-content-between mb-3">
                    <h5 className="m-0">
                        <span role="img" aria-label="burger">🍔</span>{" "}
                        Fast Food Menu
                    </h5>

                    <button
                        type="button"
                        className="btn btn-outline-secondary d-inline-flex align-items-center gap-2"
                        onClick={() => setTheme(isDark ? "light" : "dark")}
                    >
                        {isDark ? "Light" : "Dark"}
                    </button>
                </div>


                <div className="row g-4">
                    {products.map((p) => (
                        <div className="col-12 col-md-6 col-lg-4" key={p.id}>
                            <div className="card h-100 shadow-sm">

                                <div className="ratio ratio-16x9 bg-secondary-subtle d-flex align-items-center justify-content-center">
                                    <span className="display-4 fw-semibold text-secondary">{p.title}</span>
                                </div>

                                <div className={`card-body ${cardText}`}>
                                    <h6 className="card-title">{p.title}</h6>
                                    <p className="card-text text-body-secondary">{p.desc}</p>

                                    <div className="d-flex align-items-center justify-content-between">
                                        <span className="fw-semibold">{p.price} kr</span>
                                        <button
                                            className="btn btn-primary"
                                            onClick={() => addToOrder(p)}
                                        >
                                            Add to Order
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    ))}
                </div>


                <div className="mt-5">
                    <div className="border-top border-secondary pt-4" />

                    <div className="card bg-transparent border-secondary-subtle mt-3">
                        <div className="card-body">
                            <h5 className="card-title">Your Order</h5>

                            {items.length === 0 ? (
                                <p className="text-body-secondary mb-0">
                                    No items in your order yet.
                                </p>
                            ) : (
                                <>
                                    <ul className="list-group mb-3">
                                        {items.map(({ product, qty }) => (
                                            <li
                                                key={product.id}
                                                className={`list-group-item d-flex align-items-center justify-content-between ${isDark ? "bg-dark text-light border-secondary" : ""}`}
                                            >
                                                <div>
                                                    <div className="fw-semibold">{product.title}</div>
                                                    <small className="text-body-secondary">
                                                        {product.price} kr × {qty}
                                                    </small>
                                                </div>

                                                <div className="d-flex align-items-center gap-2">
                                                    <button
                                                        className="btn btn-outline-secondary btn-sm"
                                                        onClick={() => decrease(product.id)}
                                                    >
                                                        −
                                                    </button>
                                                    <span className="px-2">{qty}</span>
                                                    <button
                                                        className="btn btn-outline-secondary btn-sm"
                                                        onClick={() => increase(product.id)}
                                                    >
                                                        +
                                                    </button>
                                                </div>
                                            </li>
                                        ))}
                                    </ul>

                                    <div className="d-flex align-items-center justify-content-between">
                                        <div className="fs-5 fw-semibold">Total: {total} kr</div>
                                        <div className="d-flex gap-2">
                                            <button className="btn btn-outline-danger" onClick={clearOrder}>
                                                Clear
                                            </button>
                                            <button className="btn btn-success">Checkout</button>
                                        </div>
                                    </div>
                                </>
                            )}
                        </div>
                    </div>
                </div>

            </div>
        </div>
    );
}
