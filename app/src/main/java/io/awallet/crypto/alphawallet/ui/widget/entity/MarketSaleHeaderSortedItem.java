package io.awallet.crypto.alphawallet.ui.widget.entity;

import io.awallet.crypto.alphawallet.entity.Token;
import io.awallet.crypto.alphawallet.ui.widget.holder.SalesOrderHeaderHolder;

/**
 * Created by James on 13/02/2018.
 */

public class MarketSaleHeaderSortedItem extends SortedItem<Token>
{
    public MarketSaleHeaderSortedItem(Token value)
    {
        super(SalesOrderHeaderHolder.VIEW_TYPE, value, 0);
    }

    @Override
    public int compare(SortedItem other)
    {
        return weight - other.weight;
    }

    @Override
    public boolean areContentsTheSame(SortedItem newItem)
    {
        return newItem.viewType == viewType
                || (((TokenBalanceSortedItem) newItem).value.getTicketCount() == value.getTicketCount())
                && ((TokenBalanceSortedItem) newItem).value.getFullName().equals(value.getFullName());
    }

    @Override
    public boolean areItemsTheSame(SortedItem other)
    {
        return other.viewType == viewType;
    }
}