SELECT
    info.food_type, info.rest_id, info.rest_name, info.favorites
FROM
    rest_info as info,
    (SELECT
        food_type, max(favorites) as favorites
    FROM
        rest_info
    GROUP BY
        food_type) as info2
WHERE
    info.favorites = info2.favorites and info.food_type = info2.food_type
ORDER BY
    food_type desc